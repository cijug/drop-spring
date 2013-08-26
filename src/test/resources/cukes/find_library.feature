@txn
Feature: Find me some plants

  Background:
    Given the following pakages exist
      | name      | url                         |
      | slideshow | gitolite@pgit1dsm:slideshow |
      | reporting | gitolite@pgit1dsm:reporting |
      | pslider   | gitolite@pgit1dsm:pslider   |

  Scenario: Should find pakages with wildcard search
    When I look for "slide"
    Then I should get
      | name      |
      | slideshow |
      | pslider   |

  Scenario: Should find all pakages
    When I get all
    Then I should get
      | name      |
      | slideshow |
      | reporting |
      | pslider   |