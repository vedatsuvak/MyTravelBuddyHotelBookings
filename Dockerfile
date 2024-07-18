FROM openjdk:17
EXPOSE 8092
ADD target/MyTravelBuddyHotelBookings-0.0.1-SNAPSHOT.war MyTravelBuddyHotelBookings-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java", "-jar", "/MyTravelBuddyHotelBookings-0.0.1-SNAPSHOT.war" ]