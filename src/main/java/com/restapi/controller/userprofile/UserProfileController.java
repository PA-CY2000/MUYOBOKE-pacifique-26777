package com.restapi.controller.userprofile;

import com.restapi.model.userprofile.ApiResponse;
import com.restapi.model.userprofile.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    
    private List<UserProfile> users = new ArrayList<>();
    private Long nextId = 26780L;

    public UserProfileController() {
        users.add(new UserProfile(26777L, "muyoboke_pacifique", "muyoboke.pacifique@example.com", "Muyoboke Pacifique", 22, "Rwanda", "Software Engineering Student", true));
        users.add(new UserProfile(26888L, "tuyishime", "tuyishime@example.com", "Tuyishime Jean", 23, "Rwanda", "Computer Science Student", true));
        users.add(new UserProfile(26779L, "gabriel_rubayiza", "gabriel.rubayiza@example.com", "Gabriel Rubayiza", 24, "Rwanda", "Business Student", false));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserProfile>>> getAllUsers() {
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(true, "Users retrieved successfully", users);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> getUserById(@PathVariable Long userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .map(user -> ResponseEntity.ok(new ApiResponse<>(true, "User found", user)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse<>(false, "User not found", null)));
    }

    @GetMapping("/search/username")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByUsername(@RequestParam String username) {
        List<UserProfile> result = users.stream()
                .filter(user -> user.getUsername().toLowerCase().contains(username.toLowerCase()))
                .toList();
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(true, "Search completed", result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/country/{country}")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByCountry(@PathVariable String country) {
        List<UserProfile> result = users.stream()
                .filter(user -> user.getCountry().equalsIgnoreCase(country))
                .toList();
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(true, "Users from " + country + " retrieved", result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search/age-range")
    public ResponseEntity<ApiResponse<List<UserProfile>>> searchByAgeRange(
            @RequestParam int minAge,
            @RequestParam int maxAge) {
        List<UserProfile> result = users.stream()
                .filter(user -> user.getAge() >= minAge && user.getAge() <= maxAge)
                .toList();
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(true, "Users in age range retrieved", result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse<List<UserProfile>>> getActiveUsers() {
        List<UserProfile> result = users.stream()
                .filter(UserProfile::isActive)
                .toList();
        ApiResponse<List<UserProfile>> response = new ApiResponse<>(true, "Active users retrieved", result);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserProfile>> createUser(@RequestBody UserProfile user) {
        user.setUserId(nextId++);
        users.add(user);
        ApiResponse<UserProfile> response = new ApiResponse<>(true, "User profile created successfully", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserProfile>> updateUser(@PathVariable Long userId, @RequestBody UserProfile updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equals(userId)) {
                updatedUser.setUserId(userId);
                users.set(i, updatedUser);
                ApiResponse<UserProfile> response = new ApiResponse<>(true, "User profile updated successfully", updatedUser);
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    @PatchMapping("/{userId}/activate")
    public ResponseEntity<ApiResponse<UserProfile>> activateUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(true);
                ApiResponse<UserProfile> response = new ApiResponse<>(true, "User activated successfully", user);
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    @PatchMapping("/{userId}/deactivate")
    public ResponseEntity<ApiResponse<UserProfile>> deactivateUser(@PathVariable Long userId) {
        for (UserProfile user : users) {
            if (user.getUserId().equals(userId)) {
                user.setActive(false);
                ApiResponse<UserProfile> response = new ApiResponse<>(true, "User deactivated successfully", user);
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long userId) {
        boolean removed = users.removeIf(user -> user.getUserId().equals(userId));
        if (removed) {
            ApiResponse<Void> response = new ApiResponse<>(true, "User deleted successfully", null);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, "User not found", null));
    }
}
