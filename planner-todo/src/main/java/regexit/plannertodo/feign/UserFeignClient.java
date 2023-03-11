package regexit.plannertodo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import regexit.plannerentity.entity.User;

@FeignClient(name = "planner-users")
//@FeignClient(name = "planner-users", fallback = UserFeignClient.class)
public interface UserFeignClient {
    @PostMapping("/user/id")
    ResponseEntity<User> findUserById(@RequestBody Long id);
}

