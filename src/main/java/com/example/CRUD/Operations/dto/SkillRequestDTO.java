package com.example.CRUD.Operations.dto;

import lombok.Data;
import java.util.List;

@Data
public class SkillRequestDTO {
        private String name;
        private List<Long> personIds;

}
