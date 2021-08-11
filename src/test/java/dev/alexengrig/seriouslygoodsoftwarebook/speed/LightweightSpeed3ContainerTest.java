package dev.alexengrig.seriouslygoodsoftwarebook.speed;

import dev.alexengrig.seriouslygoodsoftwarebook.ContainerTest;

class LightweightSpeed3ContainerTest extends ContainerTest<LightweightSpeed3Container> {
    @Override
    protected LightweightSpeed3Container createContainer() {
        return new LightweightSpeed3Container();
    }
}