package com.Students.Student_Management_system.DTO;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

    @NotBlank
    private String name;
    @Email
    private String email;
    @Min(1)
    private int age;

}
