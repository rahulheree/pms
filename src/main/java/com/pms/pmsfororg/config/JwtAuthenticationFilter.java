// package com.pms.pmsfororg.config;

// import com.pms.pmsfororg.repository.UserAccountRepository;
// import com.pms.pmsfororg.service.JwtService;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import java.io.IOException;
// import java.util.List;

// @Component
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     private final JwtService jwtService;
//     private final UserAccountRepository userAccountRepository;

//     public JwtAuthenticationFilter(
//             JwtService jwtService,
//             UserAccountRepository userAccountRepository) {

//         this.jwtService = jwtService;
//         this.userAccountRepository = userAccountRepository;
//     }

//     @Override
//     protected void doFilterInternal(
//             HttpServletRequest request,
//             HttpServletResponse response,
//             FilterChain filterChain)
//             throws ServletException, IOException {

//         String authHeader = request.getHeader("Authorization");

//         if (authHeader == null ||
//                 !authHeader.startsWith("Bearer ")) {

//             filterChain.doFilter(request, response);
//             return;
//         }

//         String token = authHeader.substring(7);

//         if (!jwtService.isTokenValid(token)) {
//             filterChain.doFilter(request, response);
//             return;
//         }

//         String username = jwtService.extractUsername(token);

//         if (SecurityContextHolder.getContext().getAuthentication() == null) {

//             userAccountRepository.findByUsername(username)
//                     .ifPresent(account -> {

//                         var authorities = List.of(
//                                 new SimpleGrantedAuthority(
//                                         "ROLE_" + account.getRole()
//                                 )
//                         );

//                         var authentication =
//                                 new UsernamePasswordAuthenticationToken(
//                                         username,
//                                         null,
//                                         authorities
//                                 );

//                         authentication.setDetails(
//                                 new WebAuthenticationDetailsSource()
//                                         .buildDetails(request)
//                         );

//                         SecurityContextHolder.getContext()
//                                 .setAuthentication(authentication);
//                     });
//         }

//         filterChain.doFilter(request, response);
//     }
// }


package com.pms.pmsfororg.config;

import com.pms.pmsfororg.entity.UserAccount;
import com.pms.pmsfororg.repository.UserAccountRepository;
import com.pms.pmsfororg.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserAccountRepository userAccountRepository;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            UserAccountRepository userAccountRepository) {

        this.jwtService = jwtService;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        if (!jwtService.isTokenValid(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        String username = jwtService.extractUsername(token);

        if (SecurityContextHolder.getContext().getAuthentication() == null) {

            UserAccount account = userAccountRepository
                    .findByUsername(username)
                    .orElse(null);

            if (account != null && account.getCitizen() != null) {

                Long citizenId = account.getCitizen().getId();

                var authorities = List.of(
                        new SimpleGrantedAuthority(
                                "ROLE_" + account.getRole()
                        )
                );

                /*
                 * Store Citizen ID as the authenticated principal.
                 * Therefore authentication.getName() will return
                 * the logged-in Citizen ID.
                 */
                var authentication =
                        new UsernamePasswordAuthenticationToken(
                                String.valueOf(citizenId),
                                null,
                                authorities
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}