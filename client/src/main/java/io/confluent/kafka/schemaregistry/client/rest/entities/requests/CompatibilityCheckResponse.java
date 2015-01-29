/*
 * Copyright 2015 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.confluent.kafka.schemaregistry.client.rest.entities.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.IOException;

public class CompatibilityCheckResponse {

  @NotEmpty
  private boolean isCompatible;

  public static CompatibilityCheckResponse fromJson(String json) throws IOException {
    return new ObjectMapper().readValue(json, CompatibilityCheckResponse.class);
  }

  @JsonProperty("is_compatible")
  public boolean getIsCompatible() {
    return isCompatible;
  }

  @JsonProperty("is_compatible")
  public void setIsCompatible(boolean isCompatible) {
    this.isCompatible = isCompatible;
  }

  public String toJson() throws IOException {
    return new ObjectMapper().writeValueAsString(this);
  }

}
