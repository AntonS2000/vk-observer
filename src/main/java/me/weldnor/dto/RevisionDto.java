package me.weldnor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RevisionDto {
    private Long id;

    private String username;

    private boolean isOnline;

    private LocalDateTime datetime;
}
