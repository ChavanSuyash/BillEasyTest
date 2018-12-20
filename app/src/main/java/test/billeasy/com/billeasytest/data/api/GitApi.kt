package test.billeasy.com.billeasytest.data.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import test.billeasy.com.billeasytest.data.model.GitRepository
import test.billeasy.com.billeasytest.data.model.Owner

@Suppress("unused")
interface GitApi{

    /**
     * Get the list of the pots from the API
     */
    @GET("/repositories")
    fun getRepositories(): Observable<List<GitRepository>>

    /**
     * Get the list of the contributors for selected repository
     * @param repoName
     * @return Observable<List<GitRepository>>
     */
    @GET("repos/{user_name}/{repo_name}/contributors")
    fun getContributors(@Path(value = "user_name", encoded = true) userName: String ,
                        @Path(value = "repo_name", encoded = true) repoName : String): Observable<List<Owner>>

    /**
     * Get the list of the repositories for selected user
     * @param userName
     * @return Observable<List<GitRepository>>
     */
    @GET("/users/{userName}/repos")
    fun getUserRepositories(userName : String): Observable<List<GitRepository>>

}