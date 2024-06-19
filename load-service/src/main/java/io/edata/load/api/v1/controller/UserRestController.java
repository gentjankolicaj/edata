package io.edata.load.api.v1.controller;

import io.edata.load.dto.UserDTO;
import io.edata.load.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserRestController.BASE_URI)
public class UserRestController {

  public static final String BASE_URI = "/api/v1/users/";

  private final UserService userService;

  @Autowired
  public UserRestController(UserService userService) {
    this.userService = userService;
  }


  @PreAuthorize("hasAnyRole('ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping("")
  public List<UserDTO> getAllUsers() {
    return userService.getAllDTO();
  }


  @ResponseStatus(HttpStatus.OK)
  @GetMapping("{id}")
  private UserDTO getUserById(@PathVariable("id") Long id) {
    return userService.getByIdDTO(id);
  }


  @RequestMapping("*")
  public ResponseEntity<Object> otherNotMappedRequests() {
    return new ResponseEntity<>("Wrong uri", new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }

}
