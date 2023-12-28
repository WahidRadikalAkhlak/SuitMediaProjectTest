import com.suitmedia.suitmediaprojecttest.response.UserResponse

import retrofit2.http.*

interface ApiService {
    @GET("api/users")
    suspend fun getUsers(
        @Query("page") page: Int = 1,
        @Query("per_page") per_page: Int = 10
    ): UserResponse
}