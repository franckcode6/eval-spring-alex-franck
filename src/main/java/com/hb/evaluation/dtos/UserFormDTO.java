package com.hb.evaluation.dtos;

import java.util.List;

public record UserFormDTO(String username, String password, List<String> categories) {

}
