package github.avew.io.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avew on 2/6/18.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pasal {

    private String name;

    @Builder.Default
    private List<Bupot> bupot = new ArrayList<>();

}