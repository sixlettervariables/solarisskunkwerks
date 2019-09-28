/*
Copyright (c) 2008~2009, Justin R. Bengtson (poopshotgun@yahoo.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
        this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
        this list of conditions and the following disclaimer in the
        documentation and/or other materials provided with the distribution.
    * Neither the name of Justin R. Bengtson nor the names of contributors may
        be used to endorse or promote products derived from this software
        without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package states;

import components.AvailableCode;
import components.MechModifier;

public class stChassisIMQD implements ifChassis, ifState {
    // An Inner Sphere Standard Military Quad chassis
    private final static double[] Masses = { 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0 };
    private final static int[][] IntPoints = {
        { 4, 3, 1, 2 },
        { 5, 4, 2, 3 },
        { 6, 5, 3, 4 },
        { 8, 6, 4, 6 },
        { 10, 7, 5, 7 },
        { 11, 8, 6, 8 },
        { 12, 10, 6, 10 },
        { 14, 11, 7, 11 },
        { 16, 12, 8, 12 },
        { 18, 13, 9, 13 },
        { 20, 14, 10, 14 },
        { 21, 15, 10, 15 },
        { 22, 15, 11, 15 },
        { 23, 16, 12, 16 },
        { 25, 17, 13, 17 },
        { 27, 18, 14, 18 },
        { 29, 19, 15, 19 },
        { 30, 20, 16, 20 },
        { 31, 21, 17, 21 } };
    private final static AvailableCode AC = new AvailableCode( AvailableCode.TECH_BOTH );

    public stChassisIMQD() {
        AC.SetISCodes( 'C', 'C', 'C', 'C', 'C' );
        AC.SetISDates( 0, 0, false, 2300, 0, 0, false, false );
        AC.SetISFactions( "", "", "TH", "" );
        AC.SetCLCodes( 'C', 'X', 'C', 'C', 'C' );
        AC.SetCLDates( 0, 0, false, 2300, 0, 0, false, false );
        AC.SetCLFactions( "", "", "TH", "" );
        AC.SetRulesLevels( AvailableCode.RULES_UNALLOWED, AvailableCode.RULES_TOURNAMENT, AvailableCode.RULES_UNALLOWED, AvailableCode.RULES_UNALLOWED, AvailableCode.RULES_UNALLOWED );
    }

    public boolean HasCounterpart() {
        return false;
    }

    public int GetCrits() {
        return 0;
    }
    
    public String ActualName() {
        return "Industrial Structure (Quad)";
    }

    public String CritName() {
        return "Industrial";
    }

    public String LookupName() {
        return "Industrial Structure";
    }

    public String ChatName() {
        return "Ind Quad";
    }

    public String MegaMekName( boolean UseRear ) {
        return "Industrial";
    }

    public String BookReference() {
        return "Tech Manual";
    }

    public double GetStrucTon( int Tonnage, boolean fractional ) {
        return Masses[GetIndex(Tonnage)];
    }
    
    public boolean IsQuad() {
        return true;
    }
    
    /**
     * Determines if this Chassis is a Tripod
     * @return True if this chassis is a Tripod
     */
    public boolean IsTripod() {
        return false;
    }
    
    public int GetHeadPoints() {
        // All mech heads have 3 internal structure points
        return 3;
    }

    public int GetCTPoints( int Tonnage ) {
        return IntPoints[GetIndex(Tonnage)][0];
    }

    public int GetSidePoints( int Tonnage ) {
        return IntPoints[GetIndex(Tonnage)][1];
    }
    
    public int GetArmPoints( int Tonnage ) {
        // Quads have legs for "arms" so we return the leg points
        return IntPoints[GetIndex(Tonnage)][3];
    }

    public int GetLegPoints( int Tonnage ) {
        return IntPoints[GetIndex(Tonnage)][3];
    }

    public double GetCost( int Tonnage ) {
        return 300 * Tonnage;
    }

    public double GetBVMult() {
        return 0.5f;
    }

    public boolean IncrementPlaced() {
        return false;
    }

    public boolean DecrementPlaced() {
        return false;
    }

    public AvailableCode GetAvailability() {
        return AC;
    }

    private int GetIndex( int Tonnage ) {
        return Tonnage / 5 - 2;
    }

    public MechModifier GetMechModifier() {
        return null;
    }

    // toString
    @Override
    public String toString() {
        return "Industrial";
    }

    public int GetCVPoints(int Tonnage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
