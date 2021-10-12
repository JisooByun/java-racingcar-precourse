package racinggame;

import nextstep.utils.Randoms;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0,9);
    }
}
