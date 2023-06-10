package com.api.demo.controller;

import com.api.demo.domain.user.UserDto;
import com.api.demo.service.ApiService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApiController {
    private final ApiService jsonPlaceHolderApiService;

    @GetMapping("/api/users")
    public ResponseEntity<List<UserDto>> requestUsersApi(HttpServletRequest request){
        log.info("{} {} 진입", request.getRequestURL(), request.getMethod());
        List<UserDto> list = (List<UserDto>) jsonPlaceHolderApiService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<UserDto> requestUserApi(
            HttpServletRequest request,
            @PathVariable Long id
    ) {
        log.info("{} {} 진입", request.getRequestURL(), request.getMethod());
        UserDto userDto = (UserDto) jsonPlaceHolderApiService.getOne(id);

        return ResponseEntity.ok(userDto);
    }
}
