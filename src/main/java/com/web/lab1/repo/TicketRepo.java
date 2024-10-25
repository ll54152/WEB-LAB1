package com.web.lab1.repo;

import com.web.lab1.domain.Ticket;
import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface TicketRepo extends JpaRepository<Ticket, UUID> {
    int countByvatin(Long vatin);
}
