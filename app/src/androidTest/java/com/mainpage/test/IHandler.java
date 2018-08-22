//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.rong.imlib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.rong.imlib.IChatRoomHistoryMessageCallback;
import io.rong.imlib.IConnectionStatusListener;
import io.rong.imlib.IDownloadMediaCallback;
import io.rong.imlib.IDownloadMediaMessageCallback;
import io.rong.imlib.IGetNotificationQuietHoursCallback;
import io.rong.imlib.IGetUserStatusCallback;
import io.rong.imlib.IIntegerCallback;
import io.rong.imlib.ILogCallback;
import io.rong.imlib.ILongCallback;
import io.rong.imlib.IOperationCallback;
import io.rong.imlib.IResultCallback;
import io.rong.imlib.ISendMediaMessageCallback;
import io.rong.imlib.ISendMessageCallback;
import io.rong.imlib.ISetUserStatusCallback;
import io.rong.imlib.IStringCallback;
import io.rong.imlib.IUploadCallback;
import io.rong.imlib.OnReceiveMessageListener;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.SearchConversationResult;
import io.rong.imlib.model.UserData;
import java.util.ArrayList;
import java.util.List;

public interface IHandler extends IInterface {
    void connect(String var1, IStringCallback var2) throws RemoteException;

    void disconnect(boolean var1, IOperationCallback var2) throws RemoteException;

    void registerMessageType(String var1) throws RemoteException;

    int getTotalUnreadCount() throws RemoteException;

    int getUnreadCount(int[] var1) throws RemoteException;

    int getUnreadCountById(int var1, String var2) throws RemoteException;

    void setOnReceiveMessageListener(OnReceiveMessageListener var1) throws RemoteException;

    void setConnectionStatusListener(IConnectionStatusListener var1) throws RemoteException;

    Message getMessage(int var1) throws RemoteException;

    Message insertMessage(Message var1) throws RemoteException;

    void sendMessage(Message var1, String var2, String var3, ISendMessageCallback var4) throws RemoteException;

    void sendDirectionalMessage(Message var1, String var2, String var3, String[] var4, ISendMessageCallback var5) throws RemoteException;

    void sendMediaMessage(Message var1, String var2, String var3, ISendMediaMessageCallback var4) throws RemoteException;

    void sendLocationMessage(Message var1, String var2, String var3, ISendMessageCallback var4) throws RemoteException;

    Message sendStatusMessage(Message var1, ILongCallback var2) throws RemoteException;

    List<Message> getNewestMessages(Conversation var1, int var2) throws RemoteException;

    List<Message> getOlderMessages(Conversation var1, long var2, int var4) throws RemoteException;

    void getRemoteHistoryMessages(Conversation var1, long var2, int var4, IResultCallback var5) throws RemoteException;

    void getChatroomHistoryMessages(String var1, long var2, int var4, int var5, IChatRoomHistoryMessageCallback var6) throws RemoteException;

    void getUserStatus(String var1, IGetUserStatusCallback var2) throws RemoteException;

    void setUserStatus(int var1, ISetUserStatusCallback var2) throws RemoteException;

    List<Message> getOlderMessagesByObjectName(Conversation var1, String var2, long var3, int var5, boolean var6) throws RemoteException;

    boolean deleteMessage(int[] var1) throws RemoteException;

    void deleteMessages(int var1, String var2, Message[] var3, IOperationCallback var4) throws RemoteException;

    boolean deleteConversationMessage(int var1, String var2) throws RemoteException;

    boolean clearMessages(Conversation var1) throws RemoteException;

    boolean clearMessagesUnreadStatus(Conversation var1) throws RemoteException;

    boolean setMessageExtra(int var1, String var2) throws RemoteException;

    boolean setMessageReceivedStatus(int var1, int var2) throws RemoteException;

    boolean setMessageSentStatus(int var1, int var2) throws RemoteException;

    Message getMessageByUid(String var1) throws RemoteException;

    List<Conversation> getConversationList() throws RemoteException;

    List<Conversation> getConversationListByType(int[] var1) throws RemoteException;

    Conversation getConversation(int var1, String var2) throws RemoteException;

    boolean removeConversation(int var1, String var2) throws RemoteException;

    boolean saveConversationDraft(Conversation var1, String var2) throws RemoteException;

    String getConversationDraft(Conversation var1) throws RemoteException;

    boolean cleanConversationDraft(Conversation var1) throws RemoteException;

    void getConversationNotificationStatus(int var1, String var2, ILongCallback var3) throws RemoteException;

    void setConversationNotificationStatus(int var1, String var2, int var3, ILongCallback var4) throws RemoteException;

    boolean setConversationTopStatus(int var1, String var2, boolean var3) throws RemoteException;

    int getConversationUnreadCount(Conversation var1) throws RemoteException;

    boolean clearConversations(int[] var1) throws RemoteException;

    void setNotificationQuietHours(String var1, int var2, IOperationCallback var3) throws RemoteException;

    void removeNotificationQuietHours(IOperationCallback var1) throws RemoteException;

    void getNotificationQuietHours(IGetNotificationQuietHoursCallback var1) throws RemoteException;

    boolean updateConversationInfo(int var1, String var2, String var3, String var4) throws RemoteException;

    void getDiscussion(String var1, IResultCallback var2) throws RemoteException;

    void setDiscussionName(String var1, String var2, IOperationCallback var3) throws RemoteException;

    void createDiscussion(String var1, List<String> var2, IResultCallback var3) throws RemoteException;

    void addMemberToDiscussion(String var1, List<String> var2, IOperationCallback var3) throws RemoteException;

    void removeDiscussionMember(String var1, String var2, IOperationCallback var3) throws RemoteException;

    void quitDiscussion(String var1, IOperationCallback var2) throws RemoteException;

    void syncGroup(List<Group> var1, IOperationCallback var2) throws RemoteException;

    void joinGroup(String var1, String var2, IOperationCallback var3) throws RemoteException;

    void quitGroup(String var1, IOperationCallback var2) throws RemoteException;

    void getChatRoomInfo(String var1, int var2, int var3, IResultCallback var4) throws RemoteException;

    void reJoinChatRoom(String var1, int var2, IOperationCallback var3) throws RemoteException;

    void joinChatRoom(String var1, int var2, IOperationCallback var3) throws RemoteException;

    void joinExistChatRoom(String var1, int var2, IOperationCallback var3, boolean var4) throws RemoteException;

    void quitChatRoom(String var1, IOperationCallback var2) throws RemoteException;

    void searchPublicService(String var1, int var2, int var3, IResultCallback var4) throws RemoteException;

    void subscribePublicService(String var1, int var2, boolean var3, IOperationCallback var4) throws RemoteException;

    void getPublicServiceProfile(String var1, int var2, IResultCallback var3) throws RemoteException;

    void getPublicServiceList(IResultCallback var1) throws RemoteException;

    void uploadMedia(Message var1, IUploadCallback var2) throws RemoteException;

    void downloadMedia(Conversation var1, int var2, String var3, IDownloadMediaCallback var4) throws RemoteException;

    void downloadMediaMessage(Message var1, IDownloadMediaMessageCallback var2) throws RemoteException;

    void cancelTransferMediaMessage(Message var1, IOperationCallback var2) throws RemoteException;

    long getDeltaTime() throws RemoteException;

    void setDiscussionInviteStatus(String var1, int var2, IOperationCallback var3) throws RemoteException;

    void recallMessage(String var1, byte[] var2, String var3, int var4, IOperationCallback var5) throws RemoteException;

    void addToBlacklist(String var1, IOperationCallback var2) throws RemoteException;

    void removeFromBlacklist(String var1, IOperationCallback var2) throws RemoteException;

    String getTextMessageDraft(Conversation var1) throws RemoteException;

    boolean saveTextMessageDraft(Conversation var1, String var2) throws RemoteException;

    boolean clearTextMessageDraft(Conversation var1) throws RemoteException;

    void getBlacklist(IStringCallback var1) throws RemoteException;

    void getBlacklistStatus(String var1, IIntegerCallback var2) throws RemoteException;

    void setUserData(UserData var1, IOperationCallback var2) throws RemoteException;

    boolean updateMessageReceiptStatus(String var1, int var2, long var3) throws RemoteException;

    boolean clearUnreadByReceipt(int var1, String var2, long var3) throws RemoteException;

    long getSendTimeByMessageId(int var1) throws RemoteException;

    void getVoIPKey(int var1, String var2, String var3, IStringCallback var4) throws RemoteException;

    String getVoIPCallInfo() throws RemoteException;

    String getCurrentUserId() throws RemoteException;

    void setServerInfo(String var1, String var2) throws RemoteException;

    void getPCAuthConfig(IStringCallback var1) throws RemoteException;

    boolean setMessageContent(int var1, byte[] var2, String var3) throws RemoteException;

    List<Message> getUnreadMentionedMessages(int var1, String var2) throws RemoteException;

    boolean updateReadReceiptRequestInfo(String var1, String var2) throws RemoteException;

    void registerCmdMsgType(String var1) throws RemoteException;

    List<Message> searchMessages(String var1, int var2, String var3, int var4, long var5) throws RemoteException;

    List<SearchConversationResult> searchConversations(String var1, int[] var2, String[] var3) throws RemoteException;

    List<Message> getMatchedMessages(String var1, int var2, long var3, int var5, int var6) throws RemoteException;

    void setLogListener(ILogCallback var1) throws RemoteException;

    void getVendorToken(IStringCallback var1) throws RemoteException;

    void writeLogFile(String var1, String var2) throws RemoteException;

    long getNaviCachedTime() throws RemoteException;

    boolean getJoinMultiChatRoomEnable() throws RemoteException;

    public abstract static class Stub extends Binder implements IHandler {
        private static final String DESCRIPTOR = "io.rong.imlib.IHandler";
        static final int TRANSACTION_connect = 1;
        static final int TRANSACTION_disconnect = 2;
        static final int TRANSACTION_registerMessageType = 3;
        static final int TRANSACTION_getTotalUnreadCount = 4;
        static final int TRANSACTION_getUnreadCount = 5;
        static final int TRANSACTION_getUnreadCountById = 6;
        static final int TRANSACTION_setOnReceiveMessageListener = 7;
        static final int TRANSACTION_setConnectionStatusListener = 8;
        static final int TRANSACTION_getMessage = 9;
        static final int TRANSACTION_insertMessage = 10;
        static final int TRANSACTION_sendMessage = 11;
        static final int TRANSACTION_sendDirectionalMessage = 12;
        static final int TRANSACTION_sendMediaMessage = 13;
        static final int TRANSACTION_sendLocationMessage = 14;
        static final int TRANSACTION_sendStatusMessage = 15;
        static final int TRANSACTION_getNewestMessages = 16;
        static final int TRANSACTION_getOlderMessages = 17;
        static final int TRANSACTION_getRemoteHistoryMessages = 18;
        static final int TRANSACTION_getChatroomHistoryMessages = 19;
        static final int TRANSACTION_getUserStatus = 20;
        static final int TRANSACTION_setUserStatus = 21;
        static final int TRANSACTION_getOlderMessagesByObjectName = 22;
        static final int TRANSACTION_deleteMessage = 23;
        static final int TRANSACTION_deleteMessages = 24;
        static final int TRANSACTION_deleteConversationMessage = 25;
        static final int TRANSACTION_clearMessages = 26;
        static final int TRANSACTION_clearMessagesUnreadStatus = 27;
        static final int TRANSACTION_setMessageExtra = 28;
        static final int TRANSACTION_setMessageReceivedStatus = 29;
        static final int TRANSACTION_setMessageSentStatus = 30;
        static final int TRANSACTION_getMessageByUid = 31;
        static final int TRANSACTION_getConversationList = 32;
        static final int TRANSACTION_getConversationListByType = 33;
        static final int TRANSACTION_getConversation = 34;
        static final int TRANSACTION_removeConversation = 35;
        static final int TRANSACTION_saveConversationDraft = 36;
        static final int TRANSACTION_getConversationDraft = 37;
        static final int TRANSACTION_cleanConversationDraft = 38;
        static final int TRANSACTION_getConversationNotificationStatus = 39;
        static final int TRANSACTION_setConversationNotificationStatus = 40;
        static final int TRANSACTION_setConversationTopStatus = 41;
        static final int TRANSACTION_getConversationUnreadCount = 42;
        static final int TRANSACTION_clearConversations = 43;
        static final int TRANSACTION_setNotificationQuietHours = 44;
        static final int TRANSACTION_removeNotificationQuietHours = 45;
        static final int TRANSACTION_getNotificationQuietHours = 46;
        static final int TRANSACTION_updateConversationInfo = 47;
        static final int TRANSACTION_getDiscussion = 48;
        static final int TRANSACTION_setDiscussionName = 49;
        static final int TRANSACTION_createDiscussion = 50;
        static final int TRANSACTION_addMemberToDiscussion = 51;
        static final int TRANSACTION_removeDiscussionMember = 52;
        static final int TRANSACTION_quitDiscussion = 53;
        static final int TRANSACTION_syncGroup = 54;
        static final int TRANSACTION_joinGroup = 55;
        static final int TRANSACTION_quitGroup = 56;
        static final int TRANSACTION_getChatRoomInfo = 57;
        static final int TRANSACTION_reJoinChatRoom = 58;
        static final int TRANSACTION_joinChatRoom = 59;
        static final int TRANSACTION_joinExistChatRoom = 60;
        static final int TRANSACTION_quitChatRoom = 61;
        static final int TRANSACTION_searchPublicService = 62;
        static final int TRANSACTION_subscribePublicService = 63;
        static final int TRANSACTION_getPublicServiceProfile = 64;
        static final int TRANSACTION_getPublicServiceList = 65;
        static final int TRANSACTION_uploadMedia = 66;
        static final int TRANSACTION_downloadMedia = 67;
        static final int TRANSACTION_downloadMediaMessage = 68;
        static final int TRANSACTION_cancelTransferMediaMessage = 69;
        static final int TRANSACTION_getDeltaTime = 70;
        static final int TRANSACTION_setDiscussionInviteStatus = 71;
        static final int TRANSACTION_recallMessage = 72;
        static final int TRANSACTION_addToBlacklist = 73;
        static final int TRANSACTION_removeFromBlacklist = 74;
        static final int TRANSACTION_getTextMessageDraft = 75;
        static final int TRANSACTION_saveTextMessageDraft = 76;
        static final int TRANSACTION_clearTextMessageDraft = 77;
        static final int TRANSACTION_getBlacklist = 78;
        static final int TRANSACTION_getBlacklistStatus = 79;
        static final int TRANSACTION_setUserData = 80;
        static final int TRANSACTION_updateMessageReceiptStatus = 81;
        static final int TRANSACTION_clearUnreadByReceipt = 82;
        static final int TRANSACTION_getSendTimeByMessageId = 83;
        static final int TRANSACTION_getVoIPKey = 84;
        static final int TRANSACTION_getVoIPCallInfo = 85;
        static final int TRANSACTION_getCurrentUserId = 86;
        static final int TRANSACTION_setServerInfo = 87;
        static final int TRANSACTION_getPCAuthConfig = 88;
        static final int TRANSACTION_setMessageContent = 89;
        static final int TRANSACTION_getUnreadMentionedMessages = 90;
        static final int TRANSACTION_updateReadReceiptRequestInfo = 91;
        static final int TRANSACTION_registerCmdMsgType = 92;
        static final int TRANSACTION_searchMessages = 93;
        static final int TRANSACTION_searchConversations = 94;
        static final int TRANSACTION_getMatchedMessages = 95;
        static final int TRANSACTION_setLogListener = 96;
        static final int TRANSACTION_getVendorToken = 97;
        static final int TRANSACTION_writeLogFile = 98;
        static final int TRANSACTION_getNaviCachedTime = 99;
        static final int TRANSACTION_getJoinMultiChatRoomEnable = 100;

        public Stub() {
            this.attachInterface(this, "io.rong.imlib.IHandler");
        }

        public static IHandler asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            } else {
                IInterface iin = obj.queryLocalInterface("io.rong.imlib.IHandler");
                return (IHandler)(iin != null && iin instanceof IHandler?(IHandler)iin:new IHandler.Stub.Proxy(obj));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _result;
            String _arg1;
            long _arg2;
            int _arg3;
            List _result2;
            long _result3;
            String _result4;
            IStringCallback _result5;
            int _arg11;
            String _arg22;
            byte[] _arg13;
            boolean _arg23;
            int _result7;
            List _arg24;
            int _result8;
            boolean _result9;
            long _arg14;
            boolean _arg32;
            IOperationCallback _result12;
            IOperationCallback _arg15;
            IResultCallback _result13;
            IOperationCallback _arg25;
            boolean _arg17;
            IResultCallback _arg26;
            int _arg27;
            Conversation _result17;
            ISendMessageCallback _result18;
            Message _result21;
            ArrayList _arg110;
            Message _arg113;
            int[] _result26;
            switch(code) {
                case 1:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    IStringCallback _arg117 = io.rong.imlib.IStringCallback.Stub.asInterface(data.readStrongBinder());
                    this.connect(_result4, _arg117);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result = 0 != data.readInt();
                    _arg15 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.disconnect(_result, _arg15);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    this.registerMessageType(_result4);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = this.getTotalUnreadCount();
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 5:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result26 = data.createIntArray();
                    _arg11 = this.getUnreadCount(_result26);
                    reply.writeNoException();
                    reply.writeInt(_arg11);
                    return true;
                case 6:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    _arg27 = this.getUnreadCountById(_result7, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_arg27);
                    return true;
                case 7:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    OnReceiveMessageListener _result29 = io.rong.imlib.OnReceiveMessageListener.Stub.asInterface(data.readStrongBinder());
                    this.setOnReceiveMessageListener(_result29);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    IConnectionStatusListener _result28 = io.rong.imlib.IConnectionStatusListener.Stub.asInterface(data.readStrongBinder());
                    this.setConnectionStatusListener(_result28);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg113 = this.getMessage(_result7);
                    reply.writeNoException();
                    if(_arg113 != null) {
                        reply.writeInt(1);
                        _arg113.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }

                    return true;
                case 10:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result21 = (Message)Message.CREATOR.createFromParcel(data);
                    } else {
                        _result21 = null;
                    }

                    _arg113 = this.insertMessage(_result21);
                    reply.writeNoException();
                    if(_arg113 != null) {
                        reply.writeInt(1);
                        _arg113.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }

                    return true;
                case 11:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result21 = (Message)Message.CREATOR.createFromParcel(data);
                    } else {
                        _result21 = null;
                    }

                    _arg1 = data.readString();
                    _arg22 = data.readString();
                    _result18 = io.rong.imlib.ISendMessageCallback.Stub.asInterface(data.readStrongBinder());
                    this.sendMessage(_result21, _arg1, _arg22, _result18);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result21 = (Message)Message.CREATOR.createFromParcel(data);
                    } else {
                        _result21 = null;
                    }

                    _arg1 = data.readString();
                    _arg22 = data.readString();
                    String[] _result20 = data.createStringArray();
                    ISendMessageCallback _arg36 = io.rong.imlib.ISendMessageCallback.Stub.asInterface(data.readStrongBinder());
                    this.sendDirectionalMessage(_result21, _arg1, _arg22, _result20, _arg36);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result21 = (Message)Message.CREATOR.createFromParcel(data);
                    } else {
                        _result21 = null;
                    }

                    _arg1 = data.readString();
                    _arg22 = data.readString();
                    ISendMediaMessageCallback _result19 = io.rong.imlib.ISendMediaMessageCallback.Stub.asInterface(data.readStrongBinder());
                    this.sendMediaMessage(_result21, _arg1, _arg22, _result19);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result21 = (Message)Message.CREATOR.createFromParcel(data);
                    } else {
                        _result21 = null;
                    }

                    _arg1 = data.readString();
                    _arg22 = data.readString();
                    _result18 = io.rong.imlib.ISendMessageCallback.Stub.asInterface(data.readStrongBinder());
                    this.sendLocationMessage(_result21, _arg1, _arg22, _result18);
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result21 = (Message)Message.CREATOR.createFromParcel(data);
                    } else {
                        _result21 = null;
                    }

                    ILongCallback _arg116 = io.rong.imlib.ILongCallback.Stub.asInterface(data.readStrongBinder());
                    Message _arg211 = this.sendStatusMessage(_result21, _arg116);
                    reply.writeNoException();
                    if(_arg211 != null) {
                        reply.writeInt(1);
                        _arg211.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }

                    return true;
                case 16:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg11 = data.readInt();
                    _arg24 = this.getNewestMessages(_result17, _arg11);
                    reply.writeNoException();
                    reply.writeTypedList(_arg24);
                    return true;
                case 17:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg14 = data.readLong();
                    _result8 = data.readInt();
                    List _arg35 = this.getOlderMessages(_result17, _arg14, _result8);
                    reply.writeNoException();
                    reply.writeTypedList(_arg35);
                    return true;
                case 18:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg14 = data.readLong();
                    _result8 = data.readInt();
                    IResultCallback _arg34 = io.rong.imlib.IResultCallback.Stub.asInterface(data.readStrongBinder());
                    this.getRemoteHistoryMessages(_result17, _arg14, _result8, _arg34);
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg14 = data.readLong();
                    _result8 = data.readInt();
                    _arg3 = data.readInt();
                    IChatRoomHistoryMessageCallback _arg42 = io.rong.imlib.IChatRoomHistoryMessageCallback.Stub.asInterface(data.readStrongBinder());
                    this.getChatroomHistoryMessages(_result4, _arg14, _result8, _arg3, _arg42);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    IGetUserStatusCallback _arg115 = io.rong.imlib.IGetUserStatusCallback.Stub.asInterface(data.readStrongBinder());
                    this.getUserStatus(_result4, _arg115);
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    ISetUserStatusCallback _arg114 = io.rong.imlib.ISetUserStatusCallback.Stub.asInterface(data.readStrongBinder());
                    this.setUserStatus(_result7, _arg114);
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg1 = data.readString();
                    _arg2 = data.readLong();
                    _arg3 = data.readInt();
                    boolean _arg41 = 0 != data.readInt();
                    _result2 = this.getOlderMessagesByObjectName(_result17, _arg1, _arg2, _arg3, _arg41);
                    reply.writeNoException();
                    reply.writeTypedList(_result2);
                    return true;
                case 23:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result26 = data.createIntArray();
                    _arg17 = this.deleteMessage(_result26);
                    reply.writeNoException();
                    reply.writeInt(_arg17?1:0);
                    return true;
                case 24:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    Message[] _arg210 = (Message[])data.createTypedArray(Message.CREATOR);
                    _result12 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.deleteMessages(_result7, _arg1, _arg210, _result12);
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    _arg23 = this.deleteConversationMessage(_result7, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_arg23?1:0);
                    return true;
                case 26:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg17 = this.clearMessages(_result17);
                    reply.writeNoException();
                    reply.writeInt(_arg17?1:0);
                    return true;
                case 27:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg17 = this.clearMessagesUnreadStatus(_result17);
                    reply.writeNoException();
                    reply.writeInt(_arg17?1:0);
                    return true;
                case 28:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    _arg23 = this.setMessageExtra(_result7, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_arg23?1:0);
                    return true;
                case 29:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg11 = data.readInt();
                    _arg23 = this.setMessageReceivedStatus(_result7, _arg11);
                    reply.writeNoException();
                    reply.writeInt(_arg23?1:0);
                    return true;
                case 30:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg11 = data.readInt();
                    _arg23 = this.setMessageSentStatus(_result7, _arg11);
                    reply.writeNoException();
                    reply.writeInt(_arg23?1:0);
                    return true;
                case 31:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg113 = this.getMessageByUid(_result4);
                    reply.writeNoException();
                    if(_arg113 != null) {
                        reply.writeInt(1);
                        _arg113.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }

                    return true;
                case 32:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    List _result27 = this.getConversationList();
                    reply.writeNoException();
                    reply.writeTypedList(_result27);
                    return true;
                case 33:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result26 = data.createIntArray();
                    List _arg112 = this.getConversationListByType(_result26);
                    reply.writeNoException();
                    reply.writeTypedList(_arg112);
                    return true;
                case 34:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    Conversation _arg29 = this.getConversation(_result7, _arg1);
                    reply.writeNoException();
                    if(_arg29 != null) {
                        reply.writeInt(1);
                        _arg29.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }

                    return true;
                case 35:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    _arg23 = this.removeConversation(_result7, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_arg23?1:0);
                    return true;
                case 36:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg1 = data.readString();
                    _arg23 = this.saveConversationDraft(_result17, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_arg23?1:0);
                    return true;
                case 37:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg1 = this.getConversationDraft(_result17);
                    reply.writeNoException();
                    reply.writeString(_arg1);
                    return true;
                case 38:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg17 = this.cleanConversationDraft(_result17);
                    reply.writeNoException();
                    reply.writeInt(_arg17?1:0);
                    return true;
                case 39:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    ILongCallback _arg28 = io.rong.imlib.ILongCallback.Stub.asInterface(data.readStrongBinder());
                    this.getConversationNotificationStatus(_result7, _arg1, _arg28);
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    _arg27 = data.readInt();
                    ILongCallback _result16 = io.rong.imlib.ILongCallback.Stub.asInterface(data.readStrongBinder());
                    this.setConversationNotificationStatus(_result7, _arg1, _arg27, _result16);
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    _arg23 = 0 != data.readInt();
                    _result9 = this.setConversationTopStatus(_result7, _arg1, _arg23);
                    reply.writeNoException();
                    reply.writeInt(_result9?1:0);
                    return true;
                case 42:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg11 = this.getConversationUnreadCount(_result17);
                    reply.writeNoException();
                    reply.writeInt(_arg11);
                    return true;
                case 43:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result26 = data.createIntArray();
                    _arg17 = this.clearConversations(_result26);
                    reply.writeNoException();
                    reply.writeInt(_arg17?1:0);
                    return true;
                case 44:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg25 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.setNotificationQuietHours(_result4, _arg11, _arg25);
                    reply.writeNoException();
                    return true;
                case 45:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    IOperationCallback _result25 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.removeNotificationQuietHours(_result25);
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    IGetNotificationQuietHoursCallback _result24 = io.rong.imlib.IGetNotificationQuietHoursCallback.Stub.asInterface(data.readStrongBinder());
                    this.getNotificationQuietHours(_result24);
                    reply.writeNoException();
                    return true;
                case 47:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    _arg22 = data.readString();
                    String _result14 = data.readString();
                    _arg32 = this.updateConversationInfo(_result7, _arg1, _arg22, _result14);
                    reply.writeNoException();
                    reply.writeInt(_arg32?1:0);
                    return true;
                case 48:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    IResultCallback _arg111 = io.rong.imlib.IResultCallback.Stub.asInterface(data.readStrongBinder());
                    this.getDiscussion(_result4, _arg111);
                    reply.writeNoException();
                    return true;
                case 49:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg1 = data.readString();
                    _arg25 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.setDiscussionName(_result4, _arg1, _arg25);
                    reply.writeNoException();
                    return true;
                case 50:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg110 = data.createStringArrayList();
                    _arg26 = io.rong.imlib.IResultCallback.Stub.asInterface(data.readStrongBinder());
                    this.createDiscussion(_result4, _arg110, _arg26);
                    reply.writeNoException();
                    return true;
                case 51:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg110 = data.createStringArrayList();
                    _arg25 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.addMemberToDiscussion(_result4, _arg110, _arg25);
                    reply.writeNoException();
                    return true;
                case 52:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg1 = data.readString();
                    _arg25 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.removeDiscussionMember(_result4, _arg1, _arg25);
                    reply.writeNoException();
                    return true;
                case 53:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg15 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.quitDiscussion(_result4, _arg15);
                    reply.writeNoException();
                    return true;
                case 54:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    ArrayList _result23 = data.createTypedArrayList(Group.CREATOR);
                    _arg15 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.syncGroup(_result23, _arg15);
                    reply.writeNoException();
                    return true;
                case 55:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg1 = data.readString();
                    _arg25 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.joinGroup(_result4, _arg1, _arg25);
                    reply.writeNoException();
                    return true;
                case 56:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg15 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.quitGroup(_result4, _arg15);
                    reply.writeNoException();
                    return true;
                case 57:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg27 = data.readInt();
                    _result13 = io.rong.imlib.IResultCallback.Stub.asInterface(data.readStrongBinder());
                    this.getChatRoomInfo(_result4, _arg11, _arg27, _result13);
                    reply.writeNoException();
                    return true;
                case 58:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg25 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.reJoinChatRoom(_result4, _arg11, _arg25);
                    reply.writeNoException();
                    return true;
                case 59:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg25 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.joinChatRoom(_result4, _arg11, _arg25);
                    reply.writeNoException();
                    return true;
                case 60:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg25 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    _result9 = 0 != data.readInt();
                    this.joinExistChatRoom(_result4, _arg11, _arg25, _result9);
                    reply.writeNoException();
                    return true;
                case 61:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg15 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.quitChatRoom(_result4, _arg15);
                    reply.writeNoException();
                    return true;
                case 62:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg27 = data.readInt();
                    _result13 = io.rong.imlib.IResultCallback.Stub.asInterface(data.readStrongBinder());
                    this.searchPublicService(_result4, _arg11, _arg27, _result13);
                    reply.writeNoException();
                    return true;
                case 63:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg23 = 0 != data.readInt();
                    _result12 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.subscribePublicService(_result4, _arg11, _arg23, _result12);
                    reply.writeNoException();
                    return true;
                case 64:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg26 = io.rong.imlib.IResultCallback.Stub.asInterface(data.readStrongBinder());
                    this.getPublicServiceProfile(_result4, _arg11, _arg26);
                    reply.writeNoException();
                    return true;
                case 65:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    IResultCallback _result22 = io.rong.imlib.IResultCallback.Stub.asInterface(data.readStrongBinder());
                    this.getPublicServiceList(_result22);
                    reply.writeNoException();
                    return true;
                case 66:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result21 = (Message)Message.CREATOR.createFromParcel(data);
                    } else {
                        _result21 = null;
                    }

                    IUploadCallback _arg19 = io.rong.imlib.IUploadCallback.Stub.asInterface(data.readStrongBinder());
                    this.uploadMedia(_result21, _arg19);
                    reply.writeNoException();
                    return true;
                case 67:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg11 = data.readInt();
                    _arg22 = data.readString();
                    IDownloadMediaCallback _result11 = io.rong.imlib.IDownloadMediaCallback.Stub.asInterface(data.readStrongBinder());
                    this.downloadMedia(_result17, _arg11, _arg22, _result11);
                    reply.writeNoException();
                    return true;
                case 68:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result21 = (Message)Message.CREATOR.createFromParcel(data);
                    } else {
                        _result21 = null;
                    }

                    IDownloadMediaMessageCallback _arg18 = io.rong.imlib.IDownloadMediaMessageCallback.Stub.asInterface(data.readStrongBinder());
                    this.downloadMediaMessage(_result21, _arg18);
                    reply.writeNoException();
                    return true;
                case 69:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result21 = (Message)Message.CREATOR.createFromParcel(data);
                    } else {
                        _result21 = null;
                    }

                    _arg15 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.cancelTransferMediaMessage(_result21, _arg15);
                    reply.writeNoException();
                    return true;
                case 70:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result3 = this.getDeltaTime();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 71:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg25 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.setDiscussionInviteStatus(_result4, _arg11, _arg25);
                    reply.writeNoException();
                    return true;
                case 72:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg13 = data.createByteArray();
                    _arg22 = data.readString();
                    _result8 = data.readInt();
                    IOperationCallback _arg33 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.recallMessage(_result4, _arg13, _arg22, _result8, _arg33);
                    reply.writeNoException();
                    return true;
                case 73:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg15 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.addToBlacklist(_result4, _arg15);
                    reply.writeNoException();
                    return true;
                case 74:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg15 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.removeFromBlacklist(_result4, _arg15);
                    reply.writeNoException();
                    return true;
                case 75:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg1 = this.getTextMessageDraft(_result17);
                    reply.writeNoException();
                    reply.writeString(_arg1);
                    return true;
                case 76:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg1 = data.readString();
                    _arg23 = this.saveTextMessageDraft(_result17, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_arg23?1:0);
                    return true;
                case 77:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    if(0 != data.readInt()) {
                        _result17 = (Conversation)Conversation.CREATOR.createFromParcel(data);
                    } else {
                        _result17 = null;
                    }

                    _arg17 = this.clearTextMessageDraft(_result17);
                    reply.writeNoException();
                    reply.writeInt(_arg17?1:0);
                    return true;
                case 78:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result5 = io.rong.imlib.IStringCallback.Stub.asInterface(data.readStrongBinder());
                    this.getBlacklist(_result5);
                    reply.writeNoException();
                    return true;
                case 79:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    IIntegerCallback _arg16 = io.rong.imlib.IIntegerCallback.Stub.asInterface(data.readStrongBinder());
                    this.getBlacklistStatus(_result4, _arg16);
                    reply.writeNoException();
                    return true;
                case 80:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    UserData _result15;
                    if(0 != data.readInt()) {
                        _result15 = (UserData)UserData.CREATOR.createFromParcel(data);
                    } else {
                        _result15 = null;
                    }

                    _arg15 = io.rong.imlib.IOperationCallback.Stub.asInterface(data.readStrongBinder());
                    this.setUserData(_result15, _arg15);
                    reply.writeNoException();
                    return true;
                case 81:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg2 = data.readLong();
                    _arg32 = this.updateMessageReceiptStatus(_result4, _arg11, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_arg32?1:0);
                    return true;
                case 82:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    _arg2 = data.readLong();
                    _arg32 = this.clearUnreadByReceipt(_result7, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_arg32?1:0);
                    return true;
                case 83:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg14 = this.getSendTimeByMessageId(_result7);
                    reply.writeNoException();
                    reply.writeLong(_arg14);
                    return true;
                case 84:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    _arg22 = data.readString();
                    IStringCallback _result10 = io.rong.imlib.IStringCallback.Stub.asInterface(data.readStrongBinder());
                    this.getVoIPKey(_result7, _arg1, _arg22, _result10);
                    reply.writeNoException();
                    return true;
                case 85:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = this.getVoIPCallInfo();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 86:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = this.getCurrentUserId();
                    reply.writeNoException();
                    reply.writeString(_result4);
                    return true;
                case 87:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg1 = data.readString();
                    this.setServerInfo(_result4, _arg1);
                    reply.writeNoException();
                    return true;
                case 88:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result5 = io.rong.imlib.IStringCallback.Stub.asInterface(data.readStrongBinder());
                    this.getPCAuthConfig(_result5);
                    reply.writeNoException();
                    return true;
                case 89:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg13 = data.createByteArray();
                    _arg22 = data.readString();
                    _result9 = this.setMessageContent(_result7, _arg13, _arg22);
                    reply.writeNoException();
                    reply.writeInt(_result9?1:0);
                    return true;
                case 90:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result7 = data.readInt();
                    _arg1 = data.readString();
                    _arg24 = this.getUnreadMentionedMessages(_result7, _arg1);
                    reply.writeNoException();
                    reply.writeTypedList(_arg24);
                    return true;
                case 91:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg1 = data.readString();
                    _arg23 = this.updateReadReceiptRequestInfo(_result4, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_arg23?1:0);
                    return true;
                case 92:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    this.registerCmdMsgType(_result4);
                    reply.writeNoException();
                    return true;
                case 93:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg22 = data.readString();
                    _result8 = data.readInt();
                    long _arg31 = data.readLong();
                    _result2 = this.searchMessages(_result4, _arg11, _arg22, _result8, _arg31);
                    reply.writeNoException();
                    reply.writeTypedList(_result2);
                    return true;
                case 94:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    int[] _arg12 = data.createIntArray();
                    String[] _arg21 = data.createStringArray();
                    List _result1 = this.searchConversations(_result4, _arg12, _arg21);
                    reply.writeNoException();
                    reply.writeTypedList(_result1);
                    return true;
                case 95:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg11 = data.readInt();
                    _arg2 = data.readLong();
                    _arg3 = data.readInt();
                    int _arg4 = data.readInt();
                    _result2 = this.getMatchedMessages(_result4, _arg11, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    reply.writeTypedList(_result2);
                    return true;
                case 96:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    ILogCallback _result6 = io.rong.imlib.ILogCallback.Stub.asInterface(data.readStrongBinder());
                    this.setLogListener(_result6);
                    reply.writeNoException();
                    return true;
                case 97:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result5 = io.rong.imlib.IStringCallback.Stub.asInterface(data.readStrongBinder());
                    this.getVendorToken(_result5);
                    reply.writeNoException();
                    return true;
                case 98:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result4 = data.readString();
                    _arg1 = data.readString();
                    this.writeLogFile(_result4, _arg1);
                    reply.writeNoException();
                    return true;
                case 99:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result3 = this.getNaviCachedTime();
                    reply.writeNoException();
                    reply.writeLong(_result3);
                    return true;
                case 100:
                    data.enforceInterface("io.rong.imlib.IHandler");
                    _result = this.getJoinMultiChatRoomEnable();
                    reply.writeNoException();
                    reply.writeInt(_result?1:0);
                    return true;
                case 1598968902:
                    reply.writeString("io.rong.imlib.IHandler");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IHandler {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "io.rong.imlib.IHandler";
            }

            public void connect(String token, IStringCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(token);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void disconnect(boolean isReceivePush, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(isReceivePush?1:0);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void registerMessageType(String className) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(className);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public int getTotalUnreadCount() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                int _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public int getUnreadCount(int[] types) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                int _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeIntArray(types);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public int getUnreadCountById(int type, String targetId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                int _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(type);
                    _data.writeString(targetId);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void setOnReceiveMessageListener(OnReceiveMessageListener callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void setConnectionStatusListener(IConnectionStatusListener callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public Message getMessage(int messageId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                Message _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(messageId);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    if(0 != _reply.readInt()) {
                        _result = (Message)Message.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public Message insertMessage(Message message) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                Message _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(message != null) {
                        _data.writeInt(1);
                        message.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    if(0 != _reply.readInt()) {
                        _result = (Message)Message.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void sendMessage(Message message, String pushContent, String pushData, ISendMessageCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(message != null) {
                        _data.writeInt(1);
                        message.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeString(pushContent);
                    _data.writeString(pushData);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void sendDirectionalMessage(Message message, String pushContent, String pushData, String[] userIds, ISendMessageCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(message != null) {
                        _data.writeInt(1);
                        message.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeString(pushContent);
                    _data.writeString(pushData);
                    _data.writeStringArray(userIds);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void sendMediaMessage(Message message, String pushContent, String pushData, ISendMediaMessageCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(message != null) {
                        _data.writeInt(1);
                        message.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeString(pushContent);
                    _data.writeString(pushData);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void sendLocationMessage(Message message, String pushContent, String pushData, ISendMessageCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(message != null) {
                        _data.writeInt(1);
                        message.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeString(pushContent);
                    _data.writeString(pushData);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public Message sendStatusMessage(Message message, ILongCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                Message _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(message != null) {
                        _data.writeInt(1);
                        message.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    if(0 != _reply.readInt()) {
                        _result = (Message)Message.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public List<Message> getNewestMessages(Conversation conversation, int count) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                ArrayList _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeInt(count);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(Message.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public List<Message> getOlderMessages(Conversation conversation, long flagId, int count) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                ArrayList _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeLong(flagId);
                    _data.writeInt(count);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(Message.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void getRemoteHistoryMessages(Conversation conversation, long dataTime, int count, IResultCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeLong(dataTime);
                    _data.writeInt(count);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void getChatroomHistoryMessages(String targetId, long recordTime, int count, int order, IChatRoomHistoryMessageCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(targetId);
                    _data.writeLong(recordTime);
                    _data.writeInt(count);
                    _data.writeInt(order);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void getUserStatus(String userId, IGetUserStatusCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(userId);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void setUserStatus(int status, ISetUserStatusCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(status);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public List<Message> getOlderMessagesByObjectName(Conversation conversation, String objectName, long flagId, int count, boolean flag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                ArrayList _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeString(objectName);
                    _data.writeLong(flagId);
                    _data.writeInt(count);
                    _data.writeInt(flag?1:0);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(Message.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean deleteMessage(int[] ids) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeIntArray(ids);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void deleteMessages(int conversationType, String targetId, Message[] messages, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(conversationType);
                    _data.writeString(targetId);
                    _data.writeTypedArray(messages, 0);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(24, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public boolean deleteConversationMessage(int conversationType, String targetId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(conversationType);
                    _data.writeString(targetId);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean clearMessages(Conversation conversation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    this.mRemote.transact(26, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean clearMessagesUnreadStatus(Conversation conversation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    this.mRemote.transact(27, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean setMessageExtra(int messageId, String values) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(messageId);
                    _data.writeString(values);
                    this.mRemote.transact(28, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean setMessageReceivedStatus(int messageId, int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(messageId);
                    _data.writeInt(status);
                    this.mRemote.transact(29, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean setMessageSentStatus(int messageId, int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(messageId);
                    _data.writeInt(status);
                    this.mRemote.transact(30, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public Message getMessageByUid(String uid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                Message _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(uid);
                    this.mRemote.transact(31, _data, _reply, 0);
                    _reply.readException();
                    if(0 != _reply.readInt()) {
                        _result = (Message)Message.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public List<Conversation> getConversationList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                ArrayList _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(Conversation.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public List<Conversation> getConversationListByType(int[] types) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                ArrayList _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeIntArray(types);
                    this.mRemote.transact(33, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(Conversation.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public Conversation getConversation(int type, String targetId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                Conversation _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(type);
                    _data.writeString(targetId);
                    this.mRemote.transact(34, _data, _reply, 0);
                    _reply.readException();
                    if(0 != _reply.readInt()) {
                        _result = (Conversation)Conversation.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean removeConversation(int type, String targetId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(type);
                    _data.writeString(targetId);
                    this.mRemote.transact(35, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean saveConversationDraft(Conversation conversation, String content) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeString(content);
                    this.mRemote.transact(36, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public String getConversationDraft(Conversation conversation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                String _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    this.mRemote.transact(37, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean cleanConversationDraft(Conversation conversation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    this.mRemote.transact(38, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void getConversationNotificationStatus(int type, String targetId, ILongCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(type);
                    _data.writeString(targetId);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(39, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void setConversationNotificationStatus(int type, String targetId, int status, ILongCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(type);
                    _data.writeString(targetId);
                    _data.writeInt(status);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(40, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public boolean setConversationTopStatus(int type, String targetId, boolean isTop) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(type);
                    _data.writeString(targetId);
                    _data.writeInt(isTop?1:0);
                    this.mRemote.transact(41, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public int getConversationUnreadCount(Conversation conversation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                int _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    this.mRemote.transact(42, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean clearConversations(int[] types) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeIntArray(types);
                    this.mRemote.transact(43, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void setNotificationQuietHours(String startTime, int spanMinute, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(startTime);
                    _data.writeInt(spanMinute);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(44, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void removeNotificationQuietHours(IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(45, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void getNotificationQuietHours(IGetNotificationQuietHoursCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(46, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public boolean updateConversationInfo(int type, String targetId, String title, String portait) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(type);
                    _data.writeString(targetId);
                    _data.writeString(title);
                    _data.writeString(portait);
                    this.mRemote.transact(47, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void getDiscussion(String id, IResultCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(48, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void setDiscussionName(String id, String name, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeString(name);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(49, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void createDiscussion(String name, List<String> userIds, IResultCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(name);
                    _data.writeStringList(userIds);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(50, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void addMemberToDiscussion(String id, List<String> userIds, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeStringList(userIds);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(51, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void removeDiscussionMember(String id, String userId, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeString(userId);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(52, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void quitDiscussion(String id, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(53, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void syncGroup(List<Group> groups, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeTypedList(groups);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(54, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void joinGroup(String id, String name, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeString(name);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(55, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void quitGroup(String id, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(56, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void getChatRoomInfo(String id, int count, int type, IResultCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeInt(count);
                    _data.writeInt(type);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(57, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void reJoinChatRoom(String id, int defMessageCount, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeInt(defMessageCount);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(58, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void joinChatRoom(String id, int defMessageCount, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeInt(defMessageCount);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(59, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void joinExistChatRoom(String id, int defMessageCount, IOperationCallback callback, boolean keepMsg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeInt(defMessageCount);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    _data.writeInt(keepMsg?1:0);
                    this.mRemote.transact(60, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void quitChatRoom(String id, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(id);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(61, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void searchPublicService(String keyWords, int businessType, int searchType, IResultCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(keyWords);
                    _data.writeInt(businessType);
                    _data.writeInt(searchType);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(62, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void subscribePublicService(String targetId, int publicServiceType, boolean subscribe, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(targetId);
                    _data.writeInt(publicServiceType);
                    _data.writeInt(subscribe?1:0);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(63, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void getPublicServiceProfile(String targetId, int publicServiceType, IResultCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(targetId);
                    _data.writeInt(publicServiceType);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(64, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void getPublicServiceList(IResultCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(65, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void uploadMedia(Message message, IUploadCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(message != null) {
                        _data.writeInt(1);
                        message.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(66, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void downloadMedia(Conversation conversation, int mediaType, String imageUrl, IDownloadMediaCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeInt(mediaType);
                    _data.writeString(imageUrl);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(67, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void downloadMediaMessage(Message message, IDownloadMediaMessageCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(message != null) {
                        _data.writeInt(1);
                        message.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(68, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void cancelTransferMediaMessage(Message message, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(message != null) {
                        _data.writeInt(1);
                        message.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(69, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public long getDeltaTime() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                long _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    this.mRemote.transact(70, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readLong();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void setDiscussionInviteStatus(String targetId, int status, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(targetId);
                    _data.writeInt(status);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(71, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void recallMessage(String objectName, byte[] content, String pushContent, int messageId, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(objectName);
                    _data.writeByteArray(content);
                    _data.writeString(pushContent);
                    _data.writeInt(messageId);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(72, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void addToBlacklist(String userId, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(userId);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(73, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void removeFromBlacklist(String userId, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(userId);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(74, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public String getTextMessageDraft(Conversation conversation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                String _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    this.mRemote.transact(75, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean saveTextMessageDraft(Conversation conversation, String content) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeString(content);
                    this.mRemote.transact(76, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean clearTextMessageDraft(Conversation conversation) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(conversation != null) {
                        _data.writeInt(1);
                        conversation.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    this.mRemote.transact(77, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void getBlacklist(IStringCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(78, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void getBlacklistStatus(String userId, IIntegerCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(userId);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(79, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void setUserData(UserData userData, IOperationCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    if(userData != null) {
                        _data.writeInt(1);
                        userData.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }

                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(80, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public boolean updateMessageReceiptStatus(String targetId, int categoryId, long timestamp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(targetId);
                    _data.writeInt(categoryId);
                    _data.writeLong(timestamp);
                    this.mRemote.transact(81, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean clearUnreadByReceipt(int conversationType, String targetId, long timestamp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(conversationType);
                    _data.writeString(targetId);
                    _data.writeLong(timestamp);
                    this.mRemote.transact(82, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public long getSendTimeByMessageId(int messageId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                long _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(messageId);
                    this.mRemote.transact(83, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readLong();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void getVoIPKey(int engineType, String channelName, String extra, IStringCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(engineType);
                    _data.writeString(channelName);
                    _data.writeString(extra);
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(84, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public String getVoIPCallInfo() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                String _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    this.mRemote.transact(85, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public String getCurrentUserId() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                String _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    this.mRemote.transact(86, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void setServerInfo(String naviServer, String fileServer) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(naviServer);
                    _data.writeString(fileServer);
                    this.mRemote.transact(87, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void getPCAuthConfig(IStringCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(88, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public boolean setMessageContent(int messageId, byte[] messageContent, String objectName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(messageId);
                    _data.writeByteArray(messageContent);
                    _data.writeString(objectName);
                    this.mRemote.transact(89, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public List<Message> getUnreadMentionedMessages(int conversationType, String targetId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                ArrayList _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeInt(conversationType);
                    _data.writeString(targetId);
                    this.mRemote.transact(90, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(Message.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean updateReadReceiptRequestInfo(String msgUId, String info) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(msgUId);
                    _data.writeString(info);
                    this.mRemote.transact(91, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void registerCmdMsgType(String objName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(objName);
                    this.mRemote.transact(92, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public List<Message> searchMessages(String targetId, int conversationType, String keyword, int count, long timestamp) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                ArrayList _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(targetId);
                    _data.writeInt(conversationType);
                    _data.writeString(keyword);
                    _data.writeInt(count);
                    _data.writeLong(timestamp);
                    this.mRemote.transact(93, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(Message.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public List<SearchConversationResult> searchConversations(String keyword, int[] conversationTypes, String[] objName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                ArrayList _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(keyword);
                    _data.writeIntArray(conversationTypes);
                    _data.writeStringArray(objName);
                    this.mRemote.transact(94, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(SearchConversationResult.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public List<Message> getMatchedMessages(String targetId, int conversationType, long timestamp, int before, int after) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                ArrayList _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(targetId);
                    _data.writeInt(conversationType);
                    _data.writeLong(timestamp);
                    _data.writeInt(before);
                    _data.writeInt(after);
                    this.mRemote.transact(95, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(Message.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public void setLogListener(ILogCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(96, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void getVendorToken(IStringCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeStrongBinder(callback != null?callback.asBinder():null);
                    this.mRemote.transact(97, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public void writeLogFile(String tag, String msg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    _data.writeString(tag);
                    _data.writeString(msg);
                    this.mRemote.transact(98, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

            }

            public long getNaviCachedTime() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                long _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    this.mRemote.transact(99, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readLong();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }

            public boolean getJoinMultiChatRoomEnable() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();

                boolean _result;
                try {
                    _data.writeInterfaceToken("io.rong.imlib.IHandler");
                    this.mRemote.transact(100, _data, _reply, 0);
                    _reply.readException();
                    _result = 0 != _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }

                return _result;
            }
        }
    }
}
