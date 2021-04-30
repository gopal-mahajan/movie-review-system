# MovieReviewSystem
**Overview**

 The movie review service collects reviews for movies from its users. Later these movie reviews are used to derive insights which helps in enriching the lives of its customers with entertainment.
 

**Internal Capabilities**

*1.* Users of the service can review only movies which are released so far, they
cannot review upcoming movies.

*2.* Users can give a review-score between 1 to 10. (Higher the score the better
the liking for the movie). Currently we are not allowing a user to review the
same movie multiple times.

*3.* The service by default on-boards a user as a ‘viewer’. Later a ‘viewer’ can
be upgraded to a ‘critic’ after he/she has published more than 3 reviews
for various movies.

*4.* Critics are considered as experts in the judgement here, so critics reviews
will be captured with more weightage. i.e. 6 review rating of a critic will be
considered as 12 (2x).

**Features Added**

Each of the following features were implemented:

*1.* Adding users and movies.

*2.* User to review a movie.

*3.* List top n movies by total review score by ‘critics’ in a particular genre.

*4.* Average review score in a particular year of release.

*5.* Average review score for a particular movie.

**Sample Test Cases:**


***1. Onboard 10 movies onto your platform in 3 different years.***

a. Add Movie("Don" released in Year 2006 for Genres “Action” &“Comedy”)

b. Add Movie("Tiger" released in Year 2008 for Genre “Drama”)

c. Add Movie("Padmaavat" released in Year 2006 for Genre “Comedy”)

d. Add Movie("Lunchbox" released in Year 2021 for Genre “Drama”)

e. Add Movie("Guru" released in Year 2006 for Genre “Drama”)

f. Add Movie("Metro" released in Year 2006 for Genre “Romance”)

***Add users to the system:***

a. Add User(“SRK”)

b. Add User(“Salman”)

c. Add User(“Deepika”)

***Add Reviews:***
a. add_review(“SRK”, “Don”, 2)

b. add_review(“SRK”, “Padmavaat”, 8)

c. add_review(“Salman”, “Don”, 5)

d. add_review(“Deepika”, “Don”, 9)

e. add_review(“Deepika”, “Guru”, 6)

f. add_review(“SRK”,”Don”, 10) - Exception multiple reviews not allowed.

g. add_review(“Deepika”, “Lunchbox”, 5) - Exception movie yet to be released.

h. add_review(“SRK”, “Tiger”, 5). Since ‘SRK’ has published 3 reviews, he is promoted to ‘critic’ now.

i. add_review(“SRK”, “Metro”, 7)

