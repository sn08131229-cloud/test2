package com.example.trace.util;
import lombok.*;
@Data @AllArgsConstructor
public class ApiResponse<T> { private int code; private String message; private T data;
public static <T> ApiResponse<T> ok(T d){return new ApiResponse<>(200,"success",d);} public static ApiResponse<?> fail(String m){return new ApiResponse<>(400,m,null);} }
