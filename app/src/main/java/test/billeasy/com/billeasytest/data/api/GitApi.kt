package test.billeasy.com.billeasytest.data.api

import io.reactivex.Observable
import retrofit2.http.GET
import test.billeasy.com.billeasytest.data.model.GitRepository

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
    @GET("/repos/{repoName}/contributors")
    fun getContributors(repoName : String): Observable<List<GitRepository>>

    /**
     * Get the list of the repositories for selected user
     * @param userName
     * @return Observable<List<GitRepository>>
     */
    @GET("/repositories/users/{userName}/repos")
    fun getUserRepositories(userName : String): Observable<List<GitRepository>>

}