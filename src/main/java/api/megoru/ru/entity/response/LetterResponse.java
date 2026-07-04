package api.megoru.ru.entity.response;

import api.megoru.ru.impl.APIObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LetterResponse implements APIObject {

    private String model;
    private String created_at;
    private String response;
    private boolean done;
    private String done_reason;
    private List<Integer> context;
    private long total_duration;
    private long load_duration;
    private int prompt_eval_count;
    private long prompt_eval_duration;
    private int eval_count;
    private long eval_duration;
}
