package beta.cdc.sample;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SampleTest {

    @Test
    @Tag("sample")
    void testAdd() {
        assertThat(23 + 1).isEqualTo(24);
    }
}
