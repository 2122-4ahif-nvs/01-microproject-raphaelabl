package at.htl.entity;

import at.htl.control.LineRepository;
import at.htl.control.LocationRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import java.util.Set;
import javax.validation.Validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@QuarkusTest
public class ValidationTest {

    @Inject
    Validator validator;

    @Inject
    LineRepository lineRepo;

    @Inject
    LocationRepository locationRepo;

    @Test
    public void lineValidation(){

        Line line = new Line("Hubert Heinrich Linie");

        Set<ConstraintViolation<Line>> violations = validator.validate(line);
        if(violations.isEmpty()){
            lineRepo.save(line);
            assertThat(true);
        }
        else{
            assertThat(false);
        }

        Line line1 = new Line();

        violations = validator.validate(line1);

        if(violations.isEmpty()){
            lineRepo.save(line);
            assertThat(true);
        }
        else{
            assertThat(false);
        }
    }

    @Test
    public void busValidation(){
        Bus bus = new Bus(9, "Barkas", "P1000");

        Set<ConstraintViolation<Bus>> violations = validator.validate(bus);
        assertThat(violations.isEmpty());

        Bus bus1 = new Bus();
        bus.brand = "Vw";
        bus.seat = 9;

        violations = validator.validate(bus1);
        System.out.println(violations);
        assertThat(violations.size() == 1);

    }

    @Test
    public void locationValidation(){
        Location location = new Location("Himmelweg");

        Set<ConstraintViolation<Location>> violations = validator.validate(location);
        if(violations.isEmpty()){
            locationRepo.save(location);
            assertThat(true);
        }
        else{
            assertThat(false);
        }

        Location location1 = new Location();
        violations = validator.validate(location1);

        if(violations.isEmpty()){
            locationRepo.save(location1);
            assertThat(true);
        }
        else{
            assertThat(false);
        }

    }



}
