package com.hb.evaluation.dtos;

import java.util.List;

public record UserDTO(Integer id, String username, String role, List<String> categories) {

}
