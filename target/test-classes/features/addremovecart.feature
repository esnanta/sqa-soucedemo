Feature: AddToCart Functionality

  Scenario: User add item to cart and remove it
    Given user at homepage after authorization
    And user click Add To Cart button
    Then cart will be added with one item
    And user click Add To Cart button for other item
    Then cart will have two items
    And user click Remove button for item added to cart
    Then quantity in cart will be decreased by one
