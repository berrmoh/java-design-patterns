/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.dynamicproxy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class leverages Lombok and Jackson annotations to reduce boilerplate code, improve maintainability,
 * and control serialization behavior. 
 * 
 * - @Data: Generates standard methods like getters, setters, toString, equals, and hashCode.
 * - @AllArgsConstructor: Creates a constructor with parameters for all fields.
 * - @NoArgsConstructor(force = true): Generates a no-argument constructor, initializing final fields with default values.
 * - @Builder: Implements the builder pattern for flexible and readable object creation.
 * - @JsonInclude(JsonInclude.Include.NON_NULL): Ensures null fields are excluded during JSON serialization, reducing data size and improving clarity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Album {

    /**
   * Unique identifier for the album.
   */
  @NotNull(message = "ID cannot be null")
  private Integer id;

  /**
   * Title of the album.
   */
  @NotNull(message = "Title cannot be null")
  @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
  private String title;

  /**
   * Identifier for the user who owns or created the album.
   */
  @NotNull(message = "User ID cannot be null")
  private Integer userId;

  /**
   * Prints album details for logging purposes.
   */
  public void printAlbumDetails() {
    logger.info("Album Details: ID = {}, Title = {}, User ID = {}", this.id, this.title, this.userId);
  }

}
