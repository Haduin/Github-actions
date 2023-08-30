# Github user details call

idea of this project is to fetch github user details like
- repository
- branches
- commits

# How to use it
simply download project, default http GET method is used on localhost:9090

you have to use two additional headers param 
- `username` - which is github account you want to see
- `Accept` - accepts only `application/json`

# Response body
Array of :
- repositoryName
- ownerLogin
- branches
  - name
  - commit
    - sha