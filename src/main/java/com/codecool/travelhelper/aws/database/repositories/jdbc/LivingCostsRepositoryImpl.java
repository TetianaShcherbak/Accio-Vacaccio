package com.codecool.travelhelper.aws.database.repositories.jdbc;

import com.codecool.travelhelper.aws.database.repositories.LivingCostsRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
public class LivingCostsRepositoryImpl {

    @Autowired
    LivingCostsRepository livingCostsRepository;


}
