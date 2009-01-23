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

package ssw.states;

import ssw.Constants;
import ssw.components.AvailableCode;
import ssw.components.JumpJet;
import ssw.components.MechModifier;

public class stJumpJetISUMU implements ifJumpJetFactory, ifState {
    private AvailableCode AC = new AvailableCode( false, 'E', 'X', 'X', 'E', 3066, 0, 0, "LA", "", false, false, 3062, true, "LA", Constants.EXPERIMENTAL, Constants.EXPERIMENTAL );

    public boolean IsClan() {
        return false;
    }

    public boolean IsImproved() {
        return false;
    }

    public boolean IsUMU() {
        return true;
    }

    public JumpJet GetJumpJet() {
        return new JumpJet( "Mech UMU", "Mech UMU", 1, AC );
    }

    public float GetCost() {
        return 200.0f;
    }

    public float GetTonnage() {
        return 1.0f;
    }

    public int GetNumCrits() {
        return 1;
    }

    public AvailableCode GetAvailability() {
        return AC;
    }

    public MechModifier GetMechModifier() {
        return null;
    }

    public String GetLookupName() {
        return "Mech UMU";
    }
}
