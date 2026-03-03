package com.example.CRUD.Operations.mapper;

import com.example.CRUD.Operations.dto.SkillDTO;
import com.example.CRUD.Operations.model.Skill;

public class SkillMapper {

    public static SkillDTO toDTO(Skill skill) {
        if (skill == null) return null;

        SkillDTO dto = new SkillDTO();
        dto.setId(skill.getId());
        dto.setName(skill.getName());

        return dto;
    }

    public static Skill toEntity(SkillDTO dto) {
        if (dto == null) return null;

        Skill skill = new Skill();
        skill.setId(dto.getId());
        skill.setName(dto.getName());

        return skill;
    }
}