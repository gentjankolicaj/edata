package io.edata.commons.job;

import java.util.concurrent.Callable;

public interface Job<T> extends Callable<T> {

}
