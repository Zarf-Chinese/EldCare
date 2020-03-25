package com.eldcare.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author ShiQi
 * @Date 2020/03/25 0:06
 */
@Data
public class SearchDTO<T> {
    private List<T> data;
}
