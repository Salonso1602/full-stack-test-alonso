package com.api.services.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ManagerDependants {

    @NonNull
    private Employee manager;

    private List<Employee> dependants;
}
