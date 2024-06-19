package io.edata.transform.http;

import static java.util.Objects.isNull;

import io.edata.transform.exception.HttpServerException;
import io.edata.transform.http.handler.CacheHttpRequestHandler;
import io.edata.transform.http.handler.JobHttpRequestHandler;
import io.edata.transform.http.handler.PingRequestHandler;
import io.edata.transform.http.listener.CustomExceptionListener;
import io.edata.transform.yaml.HttpPathConfigYaml;
import io.edata.transform.yaml.HttpServerConfigYaml;
import io.edata.transform.yaml.SocketConfigYaml;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.hc.core5.http.impl.bootstrap.HttpServer;
import org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.TimeValue;

@Slf4j
public class LocalHttpServer {

  private static final LocalHttpServer INSTANCE = new LocalHttpServer();
  private boolean runningServer;

  private LocalHttpServer() {
  }

  public static LocalHttpServer getInstance() {
    return INSTANCE;
  }

  public void start(HttpServerConfigYaml httpServerConfigYaml) {
    if (runningServer) {
      throw new HttpServerException(
          "Http server is running already with details : " + httpServerConfigYaml);
    } else {
      new RunnerThread(httpServerConfigYaml).start();
      runningServer = true;
    }
  }

  /**
   * <p>
   * Starter thread for http server. Also thread is a non-daemon thread which means => after
   * main-thread finishes executing , jvm doesn't shutdown. Other alternative is to use join()
   * method and stop main-thread from finishing to execute.
   * </p>
   */
  private static class RunnerThread extends Thread {

    private final HttpServerConfigYaml httpServerConfigYaml;

    RunnerThread(HttpServerConfigYaml httpServerConfigYaml) {
      //Set thread to non-daemon to stop jvm from exiting when main-thread finishes execution
      setDaemon(false);
      this.httpServerConfigYaml = httpServerConfigYaml;
    }

    @Override
    public void run() {
      try {
        final HttpServer httpServer = getHttpServer();
        httpServer.start();
        log.info("HttpServer started & listening on port {}", httpServerConfigYaml.getPort());

        //Added shutdown hook to close server
        Runtime.getRuntime()
            .addShutdownHook(new Thread(() -> httpServer.close(CloseMode.GRACEFUL)));

        //Stops waits httpServer thread to terminate, doesn't exit.
        httpServer.awaitTermination(TimeValue.MAX_VALUE);
      } catch (IOException | InterruptedException e) {
        log.error("HttpServer error.", e);
        Thread.currentThread().interrupt();
      }
    }


    /**
     * To implement below code :
     * <p>
     * String storePassword="secret"; String keyPassword="secret"; final URL
     * url=FileUtils.getFileUrl("resources/ssl/my.keystore"); return
     * SSLContexts.custom().loadKeyMaterial(url,storePassword,keyPassword);
     * </p>
     *
     * @return SSL context object returned.
     */
    private SSLContext getSSLContext() {
      return null;
    }

    private SocketConfig getSocketConfig() {
      if (isNull(httpServerConfigYaml.getSocket())) {
        return null;

      } else {
        SocketConfigYaml socketConfigYaml = httpServerConfigYaml.getSocket();
        return SocketConfig.custom().setSoTimeout(socketConfigYaml.getTimeout(), TimeUnit.SECONDS)
            .setTcpNoDelay(socketConfigYaml.isTcpDelay()).build();
      }
    }

    private HttpServer getHttpServer() {
      ServerBootstrap serverBootstrap = ServerBootstrap.bootstrap()
          .setListenerPort(httpServerConfigYaml.getPort())
          .setSocketConfig(getSocketConfig())
          .setSslContext(getSSLContext())
          .setExceptionListener(new CustomExceptionListener())
          .register("/ping", new PingRequestHandler())
          .register("/cache", new CacheHttpRequestHandler());

      if (CollectionUtils.isNotEmpty(httpServerConfigYaml.getPaths())) {
        for (HttpPathConfigYaml httpPathConfigYaml : httpServerConfigYaml.getPaths()) {
          serverBootstrap.register(httpPathConfigYaml.getPath(),
              new JobHttpRequestHandler(httpPathConfigYaml));
        }
      }
      return serverBootstrap.create();
    }
  }
}
