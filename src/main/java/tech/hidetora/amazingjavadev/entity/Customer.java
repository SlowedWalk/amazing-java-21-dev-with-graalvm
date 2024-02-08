package tech.hidetora.amazingjavadev.entity;

import org.springframework.data.annotation.Id;

/**
 * @author hidetora
 * @version 1.0.0
 * @since 2022/04/18
 */
public record Customer(@Id Long id, String name) {
}
