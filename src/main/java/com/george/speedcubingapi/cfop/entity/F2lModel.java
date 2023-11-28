package com.george.speedcubingapi.cfop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "cfop_f2l")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class F2lModel {

    @Id @Field("_id")  private String algorithmId;
    @Field("algorithm_name") private String algorithmName;
    @Field("algorithm_setup") private String algorithmSetup;
    @Field("algorithm_image") private String algorithmImage;
    @Field("algorithm_cases") private List<F2lAlgorithmCase> f2lAlgorithmCases;
    @Field("subset_name") private String algorithmSubset;

    public record F2lAlgorithmCase(
        @Field("case_name") String caseName,
        @Field("case_algorithm") String caseAlgorithm,
        @Field("case_view") String caseView,
        @Field("case_likes") int caseLikes
    ){}

}
