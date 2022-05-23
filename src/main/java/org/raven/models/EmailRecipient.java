package org.raven.models;

import lombok.*;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
@Builder
public class EmailRecipient {

  private String name;

  private String address;

}
