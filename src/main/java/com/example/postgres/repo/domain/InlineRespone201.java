package com.example.postgres.repo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class InlineRespone201 {
@JsonProperty("postingIdentifier")
    private int postingIdentifier;
public InlineRespone201 postingIdentifier(int originationApplicationIdentifier){
    this.postingIdentifier=postingIdentifier;
    return this;
}

}
