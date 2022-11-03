package github.avew.io.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by avew on 2/6/18.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bupot {

    private String nama;
    private Integer count;
}