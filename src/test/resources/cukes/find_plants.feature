Feature: Find me some plants

  Scenario: Should retrieve plants
    Given the following plants exist
    |name|size|
    |rose|1|
    |daffodil|2|
    And I look for "rose"
    Then I should get
    |name|
    |rose|
