package com.t01g02.project.menu;

public class SettingsModel {
    private boolean musicOn;
    private boolean soundOn;
    private final String[] options = {"Music", "Sound"};
    private int selectedOption = 0;
    private final String[] musicOptions = {"ON", "OFF"};
    private int musicSelectedOption = 0;
    private int soundSelectedOption = 0;
    private final String[] soundOptions = {"ON", "OFF"};


    public SettingsModel() {
        this.musicOn = true;
        this.soundOn = true;
    }

    public boolean isMusicOn() {
        return musicOn;
    }

    public boolean isSoundOn() {
        return soundOn;
    }

    public void toggleMusic() {this.musicOn = !musicOn;}

    public void toggleSound() {this.soundOn = !soundOn;}

    public String[] getOptions() {
        return options;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }

    public String getExitSettingsInfo() {
        return "ESC to exit Settings";
    }

    public String[] getMusicOptions() {
        return musicOptions;
    }

    public String[] getSoundOptions() {
        return soundOptions;
    }

    public int getMusicSelectedOption() {
        return musicSelectedOption;
    }

    public void setMusicSelectedOption(int musicSelectedOption) {
        this.musicSelectedOption = musicSelectedOption;
    }

    public int getSoundSelectedOption() {
        return soundSelectedOption;
    }

    public void setSoundSelectedOption(int soundSelectedOption) {
        this.soundSelectedOption = soundSelectedOption;
    }
}
