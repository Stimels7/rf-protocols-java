package rf.protocols.device.oregon.v3;

import rf.protocols.core.MessageListener;
import rf.protocols.core.PacketListener;
import rf.protocols.registry.interfaces.SignalLengthListenerFactory;
import rf.protocols.registry.interfaces.AbstractSignalListenerFactory;
import rf.protocols.core.impl.BitPacket;
import rf.protocols.core.impl.MessageFactoryPacketListener;

/**
 * @author Eugene Schava <eschava@gmail.com>
 */
public class OregonV3SignalListenerFactory
        extends AbstractSignalListenerFactory<SignalLengthListenerFactory, OregonV3SignalListenerProperties>
        implements SignalLengthListenerFactory {

    public OregonV3SignalListenerFactory() {
        super(OregonV3Message.PROTOCOL, new OregonV3SignalListenerProperties());
    }

    @Override
    public OregonV3SignalListener createListener(MessageListener messageListener) {
        PacketListener<BitPacket> packetListener = new MessageFactoryPacketListener<BitPacket, OregonV3Message>(new OregonV3MessageFactory(getProtocol()), messageListener);
        return createListener(packetListener);
    }

    @Override
    public OregonV3SignalListener createListener(PacketListener packetListener) {
        OregonV3SignalListener listener = new OregonV3SignalListener(packetListener);
        listener.setProperties(getProperties());
        return listener;
    }
}
