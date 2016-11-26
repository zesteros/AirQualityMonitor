/********************************************************************************
 * Copyright 2016 Angelo de Jesus Loza Martinez								    *
 * Licensed under the Apache License, Version 2.0 (the "License");				*
 * you may not use this file except in compliance with the License.			    *
 * You may obtain a copy of the License at										*
 *                                                                              *
 * http://www.apache.org/licenses/LICENSE-2.0									*
 *                                                                              *
 * Unless required by applicable law or agreed to in writing, software			*
 * distributed under the License is distributed on an "AS IS" BASIS,			*
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.	    *
 * See the License for the specific language governing permissions and			*
 * limitations under the License.												*
 *                                                                              *
 ********************************************************************************/
package com.zesters.airqualitymonitor.utils;

import android.bluetooth.BluetoothSocket;
import android.content.Context;

/**
 * Created by Angelo on 25/11/2016.
 * Class to get all volatile data instead of class inherited from Application
 */

public class StaticData {

    /*The sInstance variable*/
    private static StaticData sInstance;

    public String humidity;
    public String pressure;
    public String mq135voltage;
    public String temperature;
    public String seaLevel;
    public String co2;
    public String co;
    public String ethanol;
    public String nh4;
    public String toluene;
    public String acetone;
    public String altitude;
    public String isSmoke;

    public Context context;
    public boolean btConnected;
    public BluetoothSocket btSocket;
    public String address;

    private boolean mDbIsEmpty;
    private int mTimeout;

    /**
     * @return the sInstance of the global variable class
     */
    public static synchronized StaticData getsInstance() {
        if (sInstance == null) sInstance = new StaticData();
        return sInstance;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    /**
     * @return an Float array from the values read from the sensor
     */
    public float[] getAllGasesAsFloatArray() {
        float values[] = new float[getAllGasesAsStringArray().length];
        try {
            for (int i = 0; i < getAllGasesAsStringArray().length; i++)
                values[i] = Float.parseFloat(getAllGasesAsStringArray()[i]);
        } catch (Exception e) {
        }
        return values;
    }

    /**
     * @return the other environment sensors values as float array
     */
    public float[] getOtherValuesAsFloatArray() {
        float[] values = {
                Float.parseFloat(getHumidity()),
                Float.parseFloat(getTemperature()),
                Float.parseFloat(getPressure())};
        return values;
    }

    /**
     * @return all sensors values as float array
     */
    public float[] getAllSensorValuesAsFloatArray() {
        float[] values = new float[
                getAllGasesAsFloatArray().length + getOtherValuesAsFloatArray().length
                ];
        int k = 0;//counter for partition arrays lengths
        for (int i = 0; i < values.length; i++)
            if (i < getAllGasesAsFloatArray().length) values[i] = getAllGasesAsFloatArray()[i];
            else { values[i] = getOtherValuesAsFloatArray()[k]; k++; }
        return values;
    }


    /**
     * @return an String array from the values read from the sensor
     */
    public String[] getAllGasesAsStringArray() {
        String[] values = {
                getCo(),
                getCo2(),
                getEthanol(),
                getNh4(),
                getToluene(),
                getAcetone()};
        return values;
    }

    public boolean isBtConnected() {
        return btConnected;
    }

    public void isBtConnected(boolean connected) {
        this.btConnected = connected;
    }

    public String getIsSmoke() {
        return isSmoke;
    }

    public void setIsSmoke(String isSmoke) {
        this.isSmoke = isSmoke;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getMq135voltage() {
        return mq135voltage;
    }

    public void setMq135voltage(String mq135voltage) {
        this.mq135voltage = mq135voltage;
    }

    public String getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(String seaLevel) {
        this.seaLevel = seaLevel;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getEthanol() {
        return ethanol;
    }

    public void setEthanol(String ethanol) {
        this.ethanol = ethanol;
    }

    public String getNh4() {
        return nh4;
    }

    public void setNh4(String nh4) {
        this.nh4 = nh4;
    }

    public String getToluene() {
        return toluene;
    }

    public void setToluene(String toluene) {
        this.toluene = toluene;
    }

    public String getAcetone() {
        return acetone;
    }

    public void setAcetone(String acetone) {
        this.acetone = acetone;
    }

    public void setBtSocket(BluetoothSocket btSocket) {
        this.btSocket = btSocket;
    }

    public BluetoothSocket getBtSocket() {
        return btSocket;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEmptyDatabase() {
        return mDbIsEmpty;
    }

    public void isEmptyDatabase(boolean dbIsEmpty) {
        this.mDbIsEmpty = dbIsEmpty;
    }

    public int getmTimeout() {
        return mTimeout;
    }

    public void setmTimeout(int mTimeout) {
        this.mTimeout = mTimeout;
    }

}
