package uz.avotech.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.avotech.domain.Context;

@Service
@RequiredArgsConstructor
public class DatabaseService {

    private final HttpServletRequest request;
    private final Context context;

    public void print() {
        String name = context.getName();
        System.out.println(name);
    }

}
