package net.eszaray.imperium.util;

public class DialogEvent {
    private String dialog;
    private boolean isQuest;

    public DialogEvent(String dialog) {
        this.dialog = dialog;
        this.isQuest = false;
    }

    public DialogEvent(String dialog, boolean isQuest) {
        this.dialog = dialog;
        this.isQuest = isQuest;
    }

    public String getDialog() {
        return dialog;
    }

    public boolean isQuest() {
        return isQuest;
    }
}
