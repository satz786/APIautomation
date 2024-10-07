Feature: Get all incidents



Scenario: Verify GetIncident API is having value
Given I hit the GetanIncidentAPI
When I pass the URL and authentication
Then I need to validate the sys_id number in response as<sys_id>
Examples:
|sys_id|
|1c741bd70b2322007518478d83673af3|

