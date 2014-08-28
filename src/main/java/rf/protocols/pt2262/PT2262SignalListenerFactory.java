package rf.protocols.pt2262;

import rf.protocols.core.MessageListener;
import rf.protocols.core.PacketListener;
import rf.protocols.core.SignalLengthListenerFactory;
import rf.protocols.core.impl.AbstractSignalListenerFactory;
import rf.protocols.core.impl.BitPacket;
import rf.protocols.core.impl.MessageFactoryPacketListener;
import rf.protocols.core.message.CommandMessage;
import rf.protocols.core.message.CommandMessageFactory;

/**
 * @author Eugene Schava <eschava@gmail.com>
 */
public class PT2262SignalListenerFactory
        extends AbstractSignalListenerFactory<SignalLengthListenerFactory, PT2262SignalListenerProperties>
        implements SignalLengthListenerFactory {

    public PT2262SignalListenerFactory() {
        super("PT2262", new PT2262SignalListenerProperties());
    }

    @Override
    public PT2262SignalListener createListener(MessageListener messageListener) {
        MessageFactoryPacketListener<BitPacket, CommandMessage> packetListener = new MessageFactoryPacketListener<BitPacket, CommandMessage>(new CommandMessageFactory(getName()), messageListener);
        return createListener(packetListener);
    }

    @Override
    public PT2262SignalListener createListener(PacketListener packetListener) {
        PT2262SignalListener signalListener = new PT2262SignalListener(packetListener);
        signalListener.setProperties(getProperties());
        return signalListener;
    }
}
