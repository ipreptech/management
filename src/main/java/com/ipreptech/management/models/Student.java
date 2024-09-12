package com.ipreptech.management.models;

import com.ipreptech.management.enumns.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
}
