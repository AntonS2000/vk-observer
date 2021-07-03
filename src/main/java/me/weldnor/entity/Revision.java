package me.weldnor.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
public class Revision extends BaseEntity {
    private String userId;

    private boolean isOnline;
}
