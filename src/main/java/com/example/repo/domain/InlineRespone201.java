package com.example.repo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

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
