xquery version "1.0";

<data>
	{
		let $document := doc("markup.xml")
		for $x in $document//festival[@naam="tomorrowland"]/dag[@id="2"]/artiesten/artiest
		order by $x/start
		return
			<artiest>
				<naam>{$x/naam}</naam>
				<bezettings_uur>{$x/tijd_beschikbaar}</bezettings_uur>
			</artiest>
	}
</data>