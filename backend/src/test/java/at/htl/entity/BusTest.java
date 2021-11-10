package at.htl.entity;

import at.htl.control.BusRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class BusTest {
    @Inject
    BusRepository busRepository;

    @Test
    void insertBus() {
        Bus newBus = new Bus(50, "Merceds", "Tourismo");
        Bus inserted = busRepository.save(newBus);
        assertThat(inserted.seat).isEqualTo(newBus.seat);

    }
}